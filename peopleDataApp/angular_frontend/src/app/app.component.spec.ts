import { TestBed } from '@angular/core/testing';
import { AppComponent } from './app.component';
import { HenkiloFormComponent } from './components/henkilo-form/henkilo-form.component';

describe('AppComponent', () => {
  beforeEach(() => TestBed.configureTestingModule({
    declarations: [AppComponent, HenkiloFormComponent]
  }));

  it('should create the app', () => {
    expect(true).toBeTruthy();
  });
});
