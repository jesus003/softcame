<%@ Page Title="Acerca De" Language="C#" MasterPageFile="~/Site.Master" AutoEventWireup="true" CodeBehind="About.aspx.cs" Inherits="UrbaniaIntranet.About" %>

<asp:Content ID="BodyContent" ContentPlaceHolderID="MainContent" runat="server">
  
    <div class="container">
        <h2>Carousel Example</h2>  
  <div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner">
      <div class="item active">
        <img src="/Content/img/slider.png"  style="width:100%;height:300px;">
      </div>

      <div class="item">
        <img src="/Content/img/slide3.jpg" style="width:100%;height:300px;">
      </div>
    
      <div class="item">
        
          <img src="/Content/img/slide2.jpg" alt="Los Angeles" style="width:100%;height:300px;">
      </div>
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
    </div>

    <div class="row">
        <div class="col-md-12">
           
            <h2><center><b><br />Mision</b></center></h2>
            <p><center><br />
             <h4>Urbania es una empresa inmobiliaria dedicada a la difusión, comercialización, administración y construcción de bienes inmuebles, comprometida con sus clientes, su misión es brindar un servicio profesional de calidad, generando satisfacción en el servicio, a través de métodos innovadores que garanticen rapidez, seguridad y calidad para sus clientes.</h4>
                </center>
            </p>
             
        </div>
         <div class="col-md-12">
           
            <h2><center><b><br />Vision</b></center></h2>
            <p><center><br />
             <h4>Urbania es una empresa con la firme convicción de ser líderes en bienes raíces en México, a través de métodos tecnológicos y estrategias de mercadotecnia innovadoras que nos diferencien, enfocados en cumplir las expectativas de nuestros clientes, logrando el reconocimiento del mercado y de la industria inmobiliaria, permitiendo la creación de alianzas estratégicas, como plataforma para el éxito mutuo.</h4>
                </center>
            </p>
             <center><img src="Content/img/logo.png" /></center>
        </div>
        
    </div>
</asp:Content>
