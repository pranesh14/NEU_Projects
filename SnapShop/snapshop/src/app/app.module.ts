import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { NavComponent } from './nav/nav.component';
import { Home1Component } from './home1/home1.component';
import { MapComponent } from './map/map.component';
import { MiddlepaageComponent } from './middlepaage/middlepaage.component';
import { ScannerPageComponent } from './scanner-page/scanner-page.component';
import { FooterComponent } from './footer/footer.component';
import { LoginComponent } from './login/login.component';
import { AgmCoreModule } from '@agm/core';
import { ReactiveFormsModule } from '@angular/forms'; 
import { HttpClientModule } from '@angular/common/http';
import { routing } from './app.routing';
import { AuthenticationService} from '../service/authentication.service';
import { RegistrationService} from '../service/register.service';
import { scanProductService} from '../service/scanProduct.service';
import { PaymentComponent } from './payment/payment.component';
import { SearchPageComponent } from './search-page/search-page.component';
import { ProductviewComponent } from './productview/productview.component';
import { CartDisplayComponent } from './cart-display/cart-display.component';
import { cartDisplayService } from '../service/cartDisplay.service';
import { AlertComponent } from './alert/alert.component';

@NgModule({
  declarations: [
    AppComponent,
    NavComponent,
    Home1Component,
    MapComponent,
    LoginComponent,
    FooterComponent,
    MiddlepaageComponent,
    PaymentComponent,
    ScannerPageComponent,
    SearchPageComponent,
    ProductviewComponent,
    CartDisplayComponent,
    AlertComponent,
  ],
  imports: [
    BrowserModule,
    ReactiveFormsModule,
    HttpClientModule,
    routing,
    AgmCoreModule.forRoot({
      apiKey: 'AIzaSyBsMTVyI_Wb9MhHmkSa8c0NxAx6SWfDOig'
    })

  ],
  providers: [AuthenticationService, scanProductService,RegistrationService, cartDisplayService],
  bootstrap: [AppComponent]
})
export class AppModule { }