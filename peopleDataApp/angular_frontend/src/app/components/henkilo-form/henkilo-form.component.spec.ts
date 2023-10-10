import { ComponentFixture, TestBed } from '@angular/core/testing';
import { FormBuilder, FormGroup } from '@angular/forms';
import { of } from 'rxjs';
import { HenkiloService } from '../../services/henkilo.service';
import { HenkiloFormComponent } from './henkilo-form.component';

describe('HenkiloFormComponent', () => {
  let component: HenkiloFormComponent;
  let fixture: ComponentFixture<HenkiloFormComponent>;
  let mockHenkiloService: jasmine.SpyObj<HenkiloService>;
  let formBuilder: FormBuilder;

  beforeEach(() => {
    mockHenkiloService = jasmine.createSpyObj('HenkiloService', [
      'getHenkilo',
      'createHenkilo',
      'deleteHenkilo',
      'updateHenkilo',
    ]);

    TestBed.configureTestingModule({
      declarations: [HenkiloFormComponent],
      providers: [{ provide: HenkiloService, useValue: mockHenkiloService }],
    });

    fixture = TestBed.createComponent(HenkiloFormComponent);
    component = fixture.componentInstance;
    formBuilder = TestBed.inject(FormBuilder);
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should loadHenkilos on ngOnInit', () => {
    // Arrange
    mockHenkiloService.getHenkilo.and.returnValue(of([{
      nimi: '',
      henkilotunnus: '',
      osoitetiedot: '',
      kansalaisuus: '',
      aidinkieli: '',
      perhesuhdetiedot: '',
      syntymaJaKuolintiedot: ''
    }]));

    // Act
    component.ngOnInit();

    // Assert
    expect(mockHenkiloService.getHenkilo).toHaveBeenCalled();
  });

});
