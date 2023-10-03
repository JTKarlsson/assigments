import { TestBed } from '@angular/core/testing';
import { AppComponent } from './app.component';
import { HenkiloFormComponent } from './components/henkilo-form/henkilo-form.component';

describe('AppComponent', () => {
  beforeEach(() => TestBed.configureTestingModule({
    declarations: [AppComponent, HenkiloFormComponent]
  }));

  it('should create the app', () => {
    const fixture = TestBed.createComponent(AppComponent);
    const app = fixture.componentInstance;
    expect(app).toBeTruthy();
  });
});
