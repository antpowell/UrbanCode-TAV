using Microsoft.Owin;
using Owin;

[assembly: OwinStartupAttribute(typeof(VillageApp.Startup))]
namespace VillageApp
{
    public partial class Startup
    {
        public void Configuration(IAppBuilder app)
        {
            ConfigureAuth(app);
        }
    }
}
