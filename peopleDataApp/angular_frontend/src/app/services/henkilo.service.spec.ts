import { TestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { HenkiloService } from './henkilo.service';

describe('HenkiloService', () => {
  let service: HenkiloService;
  let httpMock: HttpTestingController;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [HenkiloService],
    });
    service = TestBed.inject(HenkiloService);
    httpMock = TestBed.inject(HttpTestingController);
  });

  afterEach(() => {
    httpMock.verify();
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  it('should create a Henkilo', () => {
    const mockHenkilo = { nimi: 'Perttu Kaveri' };

    service.createHenkilo(mockHenkilo).subscribe((response) => {
      expect(response).toBeTruthy();
    });

    const req = httpMock.expectOne(`${service.apiUrl}/henkilo`);
    expect(req.request.method).toBe('POST');
    req.flush(mockHenkilo);
  });

  it('should get Henkilo list', () => {
    const mockHenkiloList = [{ id: 1, nimi: 'Jaakko Perttu Kainulainen' }, { id: 2, nimi: 'Minna Mattila' }];

    service.getHenkilo().subscribe((response) => {
      expect(response).toEqual(mockHenkiloList);
    });

    const req = httpMock.expectOne(`${service.apiUrl}/henkilo`);
    expect(req.request.method).toBe('GET');
    req.flush(mockHenkiloList);
  });

  it('should update a Henkilo', () => {
    const henkiloId = 1;
    const mockHenkilo = { id: 1, nimi: 'Perttu Perttunen' };

    service.updateHenkilo(henkiloId, mockHenkilo).subscribe((response) => {
      expect(response).toBeTruthy();
    });

    const req = httpMock.expectOne(`${service.apiUrl}/henkilo/${henkiloId}`);
    expect(req.request.method).toBe('PUT');
    req.flush(mockHenkilo);
  });

  it('should delete a Henkilo', () => {
    const henkiloId = 1;

    service.deleteHenkilo(henkiloId).subscribe((response) => {
      expect(response).toBeTruthy;
    });

    const req = httpMock.expectOne(`${service.apiUrl}/henkilo/${henkiloId}`);
    expect(req.request.method).toBe('DELETE');
    req.flush({});
  });
});
