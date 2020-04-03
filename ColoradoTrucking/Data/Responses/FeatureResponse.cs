namespace ColoradoTrucking.Data.Responses {
    using System;
    using System.Collections.Generic;

    public partial class FeatureResponse : Response {
        public string message { get; set; }
        public Body body { get; set; }
    }

    public partial class Body {
        public string type { get; set; }
        public List<Feature> features { get; set; }

        public Body() { }

        public Body(List<Feature> features) {
            this.type = "FeatureCollection";
            this.features = features;
        }
    }

    public partial class Feature {
        public string type { get; set; }
        public Properties properties { get; set; }
        public Geometry geometry { get; set; }

        public override string ToString() {
            return $"{properties.inName} {properties.GetAddress()}";
        }
    }

    public partial class Properties {
        public int flag { get; set; }
        public int dayDiff { get; set; }
        public string inDOT { get; set; }
        public string inName { get; set; }
        public string inStreet { get; set; }
        public string inCity { get; set; }
        public string inState { get; set; }
        public string inZip { get; set; }
        public string inPhone { get; set; }
        public string inEmail { get; set; }
        public string inDate { get; set; }
        public string outDOT { get; set; }
        public string outName { get; set; }
        public string outDate { get; set; }
        public string outReason { get; set; }
        public string outStatus { get; set; }

        public string GetAddress() {
            return $"{inStreet} {inCity}, {inState} {inZip}";
        }
    }

    public partial class Geometry {
        public List<double> coordinates { get; set; }
    }   
}
