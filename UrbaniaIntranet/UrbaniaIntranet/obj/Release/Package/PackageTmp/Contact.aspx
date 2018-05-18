<%@ Page Title="Contacto" Language="C#" MasterPageFile="~/Site.Master" AutoEventWireup="true" CodeBehind="Contact.aspx.cs" Inherits="UrbaniaIntranet.Contact" %>

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
        <div class="col-md-6">
           
            <h2><center><b><br />Direccion</b></center></h2>
            <p><center><br />
             <h4>García Valdez, #2956<br />
                 San Felipe, Chihuahua - CH <br />
                 C.P 31203<br />
                 Telefono: 614-2754512</h4><br />
                <li><a href="https://www.urbaniabr.com/" class="button big wide smooth-scroll-middle">Visitar Sitio Web.</a></li>
                </center>
            </p>
             
        </div>
         <div class="col-md-6"><br />
            <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3501.421149031967!2d-106.09090568491709!3d28.647105982412164!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x86ea4338b6bdb1e1%3A0x2d7f41439aaeeabf!2sUrbania+Bienes+Ra%C3%ADces!5e0!3m2!1ses!2smx!4v1526659722899" width="450" height="350" frameborder="0" style="border:0" allowfullscreen></iframe>
        </div>
        
    </div>
</asp:Content>
