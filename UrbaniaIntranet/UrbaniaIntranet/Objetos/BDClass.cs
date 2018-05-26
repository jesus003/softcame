using System;
using System.Collections.Generic;
using System.Data;
using System.Data.SqlClient;
using System.Diagnostics;
using System.Linq;
using System.Web;

namespace UrbaniaIntranet.Objetos
{
    public class BDClass
    {

        public SqlConnection conectar;
        public SqlConnection conectarCheck;

        String tbl = String.Empty;
        String ipDisplay = String.Empty;
        private string connStrng;

        public BDClass()
        {
            ConexionOpen();
        }
        public string getConnStrng()
        {
            return connStrng;
        }

        #region Inicializa Conexion
        public void ConexionOpen()
        {
            try
            {

            }
            catch (Exception)
            {
                throw;
            }
            try
            {//Data source=172.168.1.67\\REPCASETAS;Initial Catalog=Telepeaje;User Id=sa;Password=Er3t4ihv; MultipleActiveResultSets=True
                string ConnString = "Data source=sql.softcame.net,2302;Initial Catalog=urbaniadb;User Id=sistemas;Password=softcame123; MultipleActiveResultSets=True";
                connStrng = ConnString;

                conectar = new SqlConnection(ConnString);
                conectarCheck = new SqlConnection(ConnString);
            }
            catch (SqlException ex)
            {
                EventLog.WriteEntry("BDClass", "CONEXION_OPEN" + ex.Message);
            }
            catch (Exception ex)
            {
                EventLog.WriteEntry("BDClass", "CONEXION_OPEN" + ex.Message);
            }
        }
        #endregion

        #region Abre Conexion
        private bool AbreConexion()
        {
            try
            {
                if (conectar.State != System.Data.ConnectionState.Open)
                {
                    ConexionOpen();
                    conectar.Open();
                }
                return true;
            }
            catch (SqlException ex)
            {
                //string metodo = "AbreConexion";
                this.CerrarConexion();
                conectar.Close();
                EventLog.WriteEntry("BDClass", "ABRIR_CONEXION" + ex.Message);
                return false;
            }
            catch (Exception ex)
            {
                EventLog.WriteEntry("BDClass", "ABRIR_CONEXION" + ex.Message);
                return false;
            }
        }

        private bool AbreConexionCheck()
        {
            try
            {
                if (conectarCheck.State != System.Data.ConnectionState.Open)
                {
                    conectarCheck.Open();
                }
                return true;
            }
            catch (SqlException ex)
            {
                //string metodo = "AbreConexion";
                this.CerrarConexion();
                conectarCheck.Close();
                EventLog.WriteEntry("BDClass", "ABRE_CONEXION_CHECK" + ex.Message);
                return false;
            }
            catch (Exception ex)
            {
                EventLog.WriteEntry("BDClass", "ABRE_CONEXION_CHECK" + ex.Message);
                return false;
            }
        }
        #endregion

        #region Cierra Conexion
        private bool CerrarConexion()
        {
            try
            {
                if (conectar.State != System.Data.ConnectionState.Closed)
                {
                    conectar.Close();
                    conectar.Dispose();
                }
                return true;
            }
            catch (SqlException ex)
            {
                //string metodo = "CerrarConexion";
                string linea = ex.StackTrace.Substring(ex.StackTrace.Length - 8, 8);

                EventLog.WriteEntry("BDClass", "CERRAR_CONEXION" + ex.Message);
                return false;
            }
            catch (Exception ex)
            {
                EventLog.WriteEntry("BDClass", "CERRAR_CONEXION" + ex.Message);
                return false;
            }
        }
        #endregion

        #region Reporte_INF_PROPIEDAD
        public DataTable cargaInfProp(ObjInfPropiedad _obj)
        {
            if (this.AbreConexion())
            {
                try
                {
                    DataTable table = new DataTable();
                    SqlCommand cmd = new SqlCommand("SP_INF_PROPIEDAD", conectar);
                    SqlDataReader read;
                    cmd.CommandType = CommandType.StoredProcedure;
                    cmd.Parameters.AddWithValue("@pde", _obj.PDE);
                    cmd.Parameters.AddWithValue("@phasta", _obj.PHASTA);
                    cmd.Parameters.AddWithValue("@ubicacion", _obj.ZONA);
                    cmd.Parameters.AddWithValue("@colonia", _obj.COLONIA);
                    cmd.Parameters.AddWithValue("@recamaras", _obj.RECAMARAS);
                    read = cmd.ExecuteReader();
                    table.Load(read);
                    read.Close();
                    CerrarConexion();
                    return table;
                }
                catch (SqlException ex)
                {
                    EventLog.WriteEntry("BDClass", "INF_PROPIEDAD" + ex.Message);
                }
                catch (Exception ex)
                {
                    EventLog.WriteEntry("BDClass", "INF_PROPIEDAD" + ex.Message);
                }
            }
            return null;
        }
        #endregion
        #region Reporte_ESTATUS_PROPIEDAD
        public DataTable getStatusPropiedad(string estatus)
        {
            if (this.AbreConexion())
            {
                try
                {
                    DataTable table = new DataTable();
                    SqlCommand cmd = new SqlCommand("SP_EST_PROPIEDAD", conectar);
                    SqlDataReader read;
                    cmd.CommandType = CommandType.StoredProcedure;
                    cmd.Parameters.AddWithValue("@estatus", estatus);
                    read = cmd.ExecuteReader();
                    table.Load(read);
                    read.Close();
                    CerrarConexion();
                    return table;
                }
                catch (SqlException ex)
                {
                    EventLog.WriteEntry("BDClass", "SP_EST_PROPIEDAD" + ex.Message);
                }
                catch (Exception ex)
                {
                    EventLog.WriteEntry("BDClass", "SP_EST_PROPIEDAD" + ex.Message);
                }
            }
            return null;
        }
        #endregion

    }
}