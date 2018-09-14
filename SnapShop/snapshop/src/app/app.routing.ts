import { Routes, RouterModule } from '@angular/router';

import { LoginComponent } from './login/login.component';
import { Home1Component } from './home1/home1.component';
import {ScannerPageComponent} from './scanner-page/scanner-page.component'
import { CartDisplayComponent } from './cart-display/cart-display.component';
import { SearchPageComponent } from './search-page/search-page.component';
import { PaymentComponent } from './payment/payment.component';
import { ProductviewComponent } from './productview/productview.component';

const appRoutes: Routes = [
   
    { path: 'Login', component: LoginComponent },
    { path: 'snapshop', component:Home1Component  },
    { path: 'scanProduct', component:ScannerPageComponent  },
    { path: 'cart', component:CartDisplayComponent  },
    { path: 'searchProduct', component:SearchPageComponent  },
    { path: 'payment', component:PaymentComponent  },
    { path: 'productDetail', component:ProductviewComponent  },
    {path: '', component: LoginComponent, pathMatch: 'full'},
    // otherwise redirect to home
    { path: '**', redirectTo: '' }
];


export const routing = RouterModule.forRoot(appRoutes);