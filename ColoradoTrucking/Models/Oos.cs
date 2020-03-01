using System;
using System.Collections.Generic;

namespace ColoradoTrucking.Models
{
    public partial class Oos
    {
        public int OosNum { get; set; }
        public int? Usdot { get; set; }
        public string LegalName { get; set; }
        public string State { get; set; }
        public string City { get; set; }
        public string Street { get; set; }
        public string Zip { get; set; }
        public string OosReason { get; set; }
        public DateTime? OosDate { get; set; }
        public string Status { get; set; }
        public decimal? Gpslatitude { get; set; }
        public decimal? Gpslongitude { get; set; }
    }
}
