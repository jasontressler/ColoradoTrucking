using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using System.Net.Http;
using ColoradoTrucking.Data;

namespace ColoradoTrucking.Data {
    public interface ILocationService {
        Task<List<string>> GetCompanyNames(string search);
        Task<string> GetMarkerData();
    }
}
