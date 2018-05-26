using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using UrbaniaIntranet.Objetos;

namespace UrbaniaIntranet.Reportes
{
    public partial class RepEstatus : System.Web.UI.Page
    {
        BDClass conn = new BDClass();
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void btnGenerar_Click(object sender, EventArgs e)
        {

            BindGrid(listEstatus.SelectedValue.ToString());


        }
        private void BindGrid(string _obj)
        {
            try
            {
                DataTable tblData = new DataTable();
                tblData = conn.getStatusPropiedad(_obj);


                gridPropiedades.DataSource = tblData;
                if (tblData.Rows.Count > 0)
                {
                    gridPropiedades.DataBind();

                }
                else
                {
                    gridPropiedades.DataSource = new DataTable();
                    gridPropiedades.DataBind();
                }
            }
            catch (Exception ex)
            {
                // log
                throw;
            }
            ScriptManager.RegisterClientScriptBlock(this, GetType(), "none", "<script>quitHourglass();</script>", false);
        }
    }
}