import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PublicationComponent } from './services/publication/publication.component';
import { AddPublicationComponent } from './components/add-publication/add-publication.component';
import { PublicationDetailsComponent } from './components/publication-details/publication-details.component';
import { PublicationsListComponent } from './components/publications-list/publications-list.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,
    PublicationComponent,
    AddPublicationComponent,
    PublicationDetailsComponent,
    PublicationsListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
