using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace ColoradoTrucking.Data.Responses {
    public class Response {
        public String message;

        public Response() {

        }

        public Response(String message) {
            this.message = message;
        }
    }
}
