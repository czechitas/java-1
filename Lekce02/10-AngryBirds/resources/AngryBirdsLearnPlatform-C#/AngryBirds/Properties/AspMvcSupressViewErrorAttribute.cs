using System;

namespace AngryBirds.Properties
{
    /// <summary>
    /// ASP.NET MVC attribute. Allows disabling inspections for MVC views within a class or a method.
    /// </summary>
    [AttributeUsage(AttributeTargets.Class | AttributeTargets.Method)]
    public sealed class AspMvcSupressViewErrorAttribute : Attribute { }
}