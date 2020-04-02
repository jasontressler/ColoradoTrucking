using System.Threading;
using System.Threading.Tasks;
using ColoradoTrucking.Data.Responses;

namespace ColoradoTrucking.Data.Services {
    public interface ILocationService {
        Task<FeatureResponse> GetCompaniesAsync(string search);
        Task<FeatureResponse> GetCompaniesAsync(string search, CancellationToken cancellationToken);

    }
}
