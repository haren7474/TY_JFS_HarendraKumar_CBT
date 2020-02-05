import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ReactiveFormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { HeaderComponent } from './header/header.component';
import { BuilderFormComponent } from './builder-form/builder-form.component';
import { RouterModule } from '@angular/router';
import { ResumePreviewComponent } from './resume-preview/resume-preview.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    HeaderComponent,
    BuilderFormComponent,
    ResumePreviewComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    AppRoutingModule,
    RouterModule.forRoot(
      [
        { path: '', component: HomeComponent },
        { path: 'header', component: HeaderComponent },
        { path: 'builderForm', component: BuilderFormComponent },
        { path: 'resumePreview', component: ResumePreviewComponent }
      ]
    )

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
