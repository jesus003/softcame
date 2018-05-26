<%@ Page Language="C#" AutoEventWireup="true" MasterPageFile="~/Site.Master" CodeBehind="infPropiedad.aspx.cs" Inherits="UrbaniaIntranet.Reportes.infPropiedad" %>
<asp:Content ID="BodyContent" ContentPlaceHolderID="MainContent" runat="server">
  
    <div class="container">
        <h2><center>Reporte Informacion de Propiedad.</center></h2>  
  
    </div>

    <div class="row">
        <br /><br /><br />
        <div class="col-md-4">
            Rango de Precio DE:<input id="txtDE" type="number" runat="server" class="form-control" /> HASTA: <input id="txtHASTA" type="number" runat="server" class="form-control"/>

        </div>
         <div class="col-md-4"><br />
            Zona:<input id="txtZona" type="text" runat="server" class="form-control"/>
        </div>
         <div class="col-md-4"><br />
            Colonia:<input id="txtColonia" type="text" runat="server" class="form-control"/>
        </div>
     </div>
    <div class="row">
        <div class="col-md-4">
            # de Recamaras:<input id="txtRecamaras" type="number" runat="server" class="form-control"/>
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
                                <asp:BoundField ItemStyle-HorizontalAlign="Center" HeaderStyle-HorizontalAlign="Center" DataField="nombre_prop" HeaderText="Nombre" />
                                <asp:BoundField ItemStyle-HorizontalAlign="Center" HeaderStyle-HorizontalAlign="Center" DataField="precio" HeaderText="Valor" />
                                <asp:BoundField ItemStyle-HorizontalAlign="Center" HeaderStyle-HorizontalAlign="Center" DataField="niveles" HeaderText="Niveles" />
                                <asp:BoundField ItemStyle-HorizontalAlign="Center" HeaderStyle-HorizontalAlign="Center" DataField="recamaras" HeaderText="Recamaras" />
                                <asp:BoundField ItemStyle-HorizontalAlign="Center" HeaderStyle-HorizontalAlign="Center" DataField="baños" HeaderText="Baños" />
                                <asp:BoundField ItemStyle-HorizontalAlign="Center" HeaderStyle-HorizontalAlign="Center" DataField="construccion" HeaderText="Construccion" />
                                <asp:BoundField ItemStyle-HorizontalAlign="Center" HeaderStyle-HorizontalAlign="Center" DataField="terreno" HeaderText="Terreno" />
                                <asp:BoundField ItemStyle-HorizontalAlign="Center" HeaderStyle-HorizontalAlign="Center" DataField="titulo_publicar" HeaderText="Titulo a Publicar" />
                                <asp:BoundField ItemStyle-HorizontalAlign="Center" HeaderStyle-HorizontalAlign="Center" DataField="observaciones" HeaderText="Observaciones" />
                                <asp:BoundField ItemStyle-HorizontalAlign="Center" HeaderStyle-HorizontalAlign="Center" DataField="ubicacion" HeaderText="Ubicacion" />
                    <asp:BoundField ItemStyle-HorizontalAlign="Center" HeaderStyle-HorizontalAlign="Center" DataField="conservacion" HeaderText="Estado de Conservacion" />
                    <asp:BoundField ItemStyle-HorizontalAlign="Center" HeaderStyle-HorizontalAlign="Center" DataField="estatus" HeaderText="Estatus" />
               </Columns>
            </asp:GridView>
        </div>
    </div>
    
</asp:Content>
