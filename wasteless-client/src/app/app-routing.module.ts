import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {MainPageComponent} from './main-page/main-page.component'
import { FirstPageComponentComponent } from './first-page-component/first-page-component.component';
import { LoginComponent } from './login/login.component';
import { ViewAllListsComponent } from './view-all-lists/view-all-lists.component';
import { GroceryItemsComponent } from './grocery-items/grocery-items.component';

const routes: Routes = [
  {path:'', component:FirstPageComponentComponent},
  {path:'grocery-lists/:idUser', component: ViewAllListsComponent},
  {path:'grocery-lists', component: ViewAllListsComponent},
  {path:'login', component:LoginComponent},
  {path:'grocery-items', component:GroceryItemsComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
