using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Security;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace UrbaniaIntranet
{
    public partial class SiteMaster : MasterPage
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            if (Session["usuario"] != null)
            {
                mMembership.Visible = true;
                mReportes.Visible = true;
            }
            else {
                mMembership.Visible = false;
                mReportes.Visible = false;
            }
        }

        protected void LoginStatus1_LoggingOut(object sender, LoginCancelEventArgs e)
        {
            mMembership.Visible = false;
            mReportes.Visible = false;
            Session.Remove("usuario");
        }
    }
}