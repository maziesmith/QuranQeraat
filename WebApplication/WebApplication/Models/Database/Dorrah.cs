//------------------------------------------------------------------------------
// <auto-generated>
//     This code was generated from a template.
//
//     Manual changes to this file may cause unexpected behavior in your application.
//     Manual changes to this file will be overwritten if the code is regenerated.
// </auto-generated>
//------------------------------------------------------------------------------

namespace WebApplication.Models.Database
{
    using System;
    using System.Collections.Generic;
    
    public partial class Dorrah
    {
        [System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Usage", "CA2214:DoNotCallOverridableMethodsInConstructors")]
        public Dorrah()
        {
            this.DorrahShahed = new HashSet<DorrahShahed>();
        }
    
        public int C_ID { get; set; }
        public string Part1 { get; set; }
        public string Part2 { get; set; }
    
        public virtual DorrahPage DorrahPage { get; set; }
        public virtual DorrahSearch DorrahSearch { get; set; }
        [System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Usage", "CA2227:CollectionPropertiesShouldBeReadOnly")]
        public virtual ICollection<DorrahShahed> DorrahShahed { get; set; }
        public virtual DorrahTitle DorrahTitle { get; set; }
    }
}
