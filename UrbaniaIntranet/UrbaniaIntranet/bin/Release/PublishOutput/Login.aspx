﻿<%@ Page Language="C#" Title="Login" MasterPageFile="~/Site.Master" AutoEventWireup="true"  CodeBehind="Login.aspx.cs" Inherits="UrbaniaIntranet.Content.Login" %>
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
           
            <asp:Login ID="Login1" runat="server" DestinationPageUrl="~/Default.aspx" OnLoggedIn="Login1_LoggedIn"></asp:Login>
            
             
        </div>
         <div class="col-md-6"><br />
            <center><img src="Content/img/logo.png" width="300" height="300" /></center>
        </div>
        
    </div>
</asp:Content>

