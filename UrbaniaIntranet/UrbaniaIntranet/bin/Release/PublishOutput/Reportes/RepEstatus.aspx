<%@ Page Language="C#" AutoEventWireup="true" MasterPageFile="~/Site.Master" CodeBehind="RepEstatus.aspx.cs" Inherits="UrbaniaIntranet.Reportes.RepEstatus" %>
<asp:Content ID="BodyContent" ContentPlaceHolderID="MainContent" runat="server">
  
    <div class="container">
        <h2><center>Reporte Informacion de Propiedad.</center></h2>  
  
    </div>

   
    <div class="row">
        <br /><br /><br />
        <div class="col-md-4">
            <asp:DropDownList ID="listEstatus" runat="server">
                <asp:ListItem Selected="True" Value="0">Seleccione una Opcion</asp:ListItem>
                <asp:ListItem>ACTIVA</asp:ListItem>
                <asp:ListItem>EN PAUSA</asp:ListItem>
                <asp:ListItem>POSTERGO</asp:ListItem>
                <asp:ListItem>SE VENDIO</asp:ListItem>
                <asp:ListItem>YA NO SE VENDE</asp:ListItem>

            </asp:DropDownList>
        </div>
         <div class="col-md-4">
             <asp:Button ID="btnGenerar" runat="server" CssClass="btn btn-primary" Text="Generar Reporte" OnClick="btnGenerar_Click" />
        </div>
        <div class="col-md-4">
            <asp:Button ID="btnExportar" Visible="false" runat="server"  CssClass="btn btn-primary" Text="Exportar" />
        </div>
    </div>  
    <div class="row">
        <div class="col-md-12">
            <asp:GridView ID="gridPropiedades" AutoGenerateColumns="false" runat="server">
                <Columns>
                                <asp:BoundField ItemStyle-HorizontalAlign="Center" HeaderStyle-HorizontalAlign="Center" DataField="TIPO" HeaderText="Tipo" />
                                <asp:BoundField ItemStyle-HorizontalAlign="Center" HeaderStyle-HorizontalAlign="Center" DataField="CLIENTE" HeaderText="Cliente" />
                                <asp:BoundField ItemStyle-HorizontalAlign="Center" HeaderStyle-HorizontalAlign="Center" DataField="NOMBRE_PROP" HeaderText="Nombre Propiedad" />
                                <asp:BoundField ItemStyle-HorizontalAlign="Center" HeaderStyle-HorizontalAlign="Center" DataField="DIRECCION" HeaderText="Direccion" />

               </Columns>
            </asp:GridView>
        </div>
    </div>
    
</asp:Content>
