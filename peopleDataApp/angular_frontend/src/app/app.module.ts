import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { HenkiloFormComponent } from './components/henkilo-form/henkilo-form.component';
import { ReadHenkilotComponent } from './components/read-henkilot/read-henkilot.component';

@NgModule({
  declarations: [
    AppComponent,
    HenkiloFormComponent,
    ReadHenkilotComponent,
  ],
  imports: [
    BrowserModule,
    ReactiveFormsModule,
    HttpClientModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {}
