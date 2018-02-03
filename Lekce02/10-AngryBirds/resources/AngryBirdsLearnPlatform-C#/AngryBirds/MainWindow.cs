using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Globalization;
using System.Linq;
using System.Runtime.Remoting.Channels;
using System.Text;
using System.Threading;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;
using AngryBirds.Engine;
using AngryBirds.Engine.Implementation;
using AngryBirds.Engine.Interfaces;
using AngryBirds.Engine.Localization;
using AngryBirds.Engine.Localization.Texts;
using AngryBirds.Levels;

namespace AngryBirds
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        private readonly string folderName = "/images/";
        public IUserDefinedGame Game { get; set; }
        
        public MainWindow()
        {
            InitializeComponent();

            //Game = ConvertorToIUserDefinedGame.Convert(new NaseHra());
            Game = ConvertorToIUserDefinedGame.Convert(new OurGame());

            Game.GameBoard.Level = Game.LoadLevel();
            Game.AngryBird.Moved += sender => EndGameWhenActionThrowException(Step);
            angryBird = new Character(Game.GameBoard);

            for (int x = 0; x < Level.BorderSize; x++)
            {
                for (int y = 0; y < Level.BorderSize; y++)
                {
                    var image = new Image();
                    var fieldType = Game.GameBoard.Level.GameBoard[x, y];

                    if (fieldType == FieldType.AngryBird)
                    {
                        Game.AngryBird.PositionX = x;
                        Game.AngryBird.PositionY = y;
                        Game.AngryBird.ActualTurn = Game.GameBoard.Level.AngryBirdTurn;
                        CloneAngryBird(Game.AngryBird);
                        Game.GameBoard.Level.GameBoard[x, y] = FieldType.Path;
                    }

                    if (fieldType == FieldType.Pig)
                    {
                        Game.Pig.PositionX = x;
                        Game.Pig.PositionY = y;
                    }
                     
                    image.Source = GetImageSource(fieldType);
                    Grid.SetColumn(image, x);
                    Grid.SetRow(image, y);
                    GameBoard.Children.Add(image);
                }
            }

            this.Loaded += MainWindow_Loaded;
            this.Closing += MainWindow_Closing;
            this.Title = Texts.ApplicationTitle;
        }

        private void MainWindow_Closing(object sender, CancelEventArgs e)
        {
            gameThread.Abort();
        }

        private void MainWindow_Loaded(object sender, RoutedEventArgs e)
        {
            gameThread = new Thread(() => EndGameWhenActionThrowException(GameStart));
            gameThread.Start();
        }

        private BitmapImage GetImageSource(FieldType field)
        {
            return new BitmapImage(new Uri(GetImageSourcePath(field), UriKind.Relative));
        }

        private string GetImageSourcePath(FieldType type)
        {
            //This can not be switch, becouse FieldType is not enum
            if (type == FieldType.AngryBird)
            {
                return GetAngryBirdImageSourcePath();
            }
            else if (type == FieldType.Pig)
            {
                return $"{folderName}pig.gif";
            }
            else if (type == FieldType.Obstacle)
            {
                return $"{folderName}obstacle.png";
            }
            else if (type == FieldType.Path)
            {
                return $"{folderName}path.png";
            }
            else
            {
                throw new NotSupportedException();
            }
        }


        private string GetAngryBirdImageSourcePath()
        {
            switch (Game.AngryBird.ActualTurn)
            {
                case TurnType.Turn0:
                    return $"{folderName}AngryBird.png";
                case TurnType.Turn90:
                    return $"{folderName}AngryBird90.png";
                case TurnType.Turn180:
                    return $"{folderName}AngryBird180.png";
                case TurnType.Turn270:
                    return $"{folderName}AngryBird270.png";
                default:
                    throw new NotSupportedException();
            }
        }

        private ICharacter angryBird;
        private static Thread gameThread;

        private void Step()
        {
            var fieldImage = GameBoard.Children
                       .Cast<Image>()
                       .First(e => (int)e.GetValue(Grid.ColumnProperty) == angryBird.PositionX && (int)e.GetValue(Grid.RowProperty) == angryBird.PositionY);
            
            fieldImage.Source = GetImageSource(FieldType.Path);

            CloneAngryBird(Game.AngryBird);

            var angryBirdImage = GameBoard.Children
                    .Cast<Image>()
                    .First(e => Grid.GetColumn(e) == angryBird.PositionX && Grid.GetRow(e) == angryBird.PositionY);
            angryBirdImage.Source = GetImageSource(FieldType.AngryBird);
        }

        private void CloneAngryBird(ICharacter character)
        {
            this.angryBird.PositionX = character.PositionX;
            this.angryBird.PositionY = character.PositionY;
            this.angryBird.ActualTurn = character.ActualTurn;
        }
        
        private void GameStart()
        {
            Thread.Sleep(1000);
            Game.Start();
            if (Game.AngryBird.PositionX == Game.Pig.PositionX && Game.AngryBird.PositionY == Game.Pig.PositionY)
            {
                MessageBox.Show(Texts.Win, Texts.WinTitle);
            }
            else
            {
                throw new ApplicationException();
            }
        }

        public static void EndGameWhenActionThrowException(Action action)
        {
            try
            {
                action();
            }
            catch
            {
                try
                {
                    if (gameThread.IsAlive)
                    {
                        gameThread.Abort();
                    }
                }
                finally
                {
                    MessageBox.Show(Texts.Lose, Texts.LoseTitle);
                }
            }
        }
    }
}
