import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PublicationsListComponent } from './components/publications-list/publications-list.component';
import { PublicationDetailsComponent } from './components/publication-details/publication-details.component';
import { AddPublicationComponent } from './components/add-publication/add-publication.component';
const routes: Routes = [
  { path: '', redirectTo: 'publications', pathMatch: 'full' },
  { path: 'publications', component: PublicationsListComponent },
  { path: 'publications/:id', component: PublicationDetailsComponent },
  { path: 'add', component: AddPublicationComponent }
];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }