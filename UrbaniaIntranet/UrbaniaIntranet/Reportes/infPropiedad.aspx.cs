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
    public partial class infPropiedad : System.Web.UI.Page
    {
        BDClass conn = new BDClass();
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void btnGenerar_Click(object sender, EventArgs e)
        {
            ObjInfPropiedad objPropiedad = setData();
            BindGrid(objPropiedad);


        }
        private void BindGrid(ObjInfPropiedad _obj)
        {
            try
            {
                DataTable tblData = new DataTable();
                tblData = conn.cargaInfProp(_obj);
                  

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
        private  ObjInfPropiedad setData() {
            ObjInfPropiedad _temp = new ObjInfPropiedad();
            _temp.COLONIA = txtColonia.Value;
            if (txtDE.Value != "") { _temp.PDE = Convert.ToInt32(txtDE.Value); }
            if (txtHASTA.Value != "") { _temp.PHASTA = Convert.ToInt32(txtHASTA.Value); }
            _temp.ZONA = txtZona.Value;
            if (txtRecamaras.Value != "") { _temp.RECAMARAS = Convert.ToInt32(txtRecamaras.Value); }
            return _temp;
        }
    }
}