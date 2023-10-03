import { ComponentFixture, TestBed } from '@angular/core/testing';
import { FormBuilder, ReactiveFormsModule } from '@angular/forms';

import { HenkiloFormComponent } from './henkilo-form.component';

describe('HenkiloFormComponent', () => {
  let component: HenkiloFormComponent;
  let fixture: ComponentFixture<HenkiloFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ReactiveFormsModule], 
      declarations: [HenkiloFormComponent], 
    }).compileComponents();
  });

  afterEach(() => {
    fixture.destroy();
  });  
  
  beforeEach(() => {
    fixture = TestBed.createComponent(HenkiloFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });
  
  it('should create the component', () => {
    expect(component).toBeTruthy();
  });
  
  it('should create a form with the expected controls', () => {
    const form = component.myForm;
    expect(form.get('nimi')).toBeTruthy();
    expect(form.get('henkilotunnus')).toBeTruthy();
  });

  it('should reset the form to its initial values on submit', () => {
    component.myForm.patchValue({
      nimi: 'Jeppe Pertti Korhonen',
      henkilotunnus: '121212-1212',
      osoitetiedot: 'Kivakuja 12, VANTAA 01700',
    });

    // Trigger the onSubmit method
    component.onSubmit();

    expect(component.myForm.value).toEqual({
      nimi: '', 
      henkilotunnus: '', 
      osoitetiedot: '', 
      kansalaisuus: '', 
      aidinkieli: '', 
      perhesuhdetiedot: '', 
      syntymaJaKuolinTiedot: '', 
    });
  });
  
});
