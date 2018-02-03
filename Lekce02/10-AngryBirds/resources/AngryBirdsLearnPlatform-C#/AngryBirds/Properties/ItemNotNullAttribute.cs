using System;

namespace AngryBirds.Properties
{
    /// <summary>
    /// Indicates that collection or enumerable value does not contain null elements.
    /// </summary>
    [AttributeUsage(
        AttributeTargets.Method | AttributeTargets.Parameter | AttributeTargets.Property |
        AttributeTargets.Delegate | AttributeTargets.Field)]
    public sealed class ItemNotNullAttribute : Attribute { }
}