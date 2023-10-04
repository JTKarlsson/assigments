import { TestBed } from '@angular/core/testing';

import { HenkiloService } from './henkilo.service';

describe('HenkiloService', () => {
  let service: HenkiloService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(HenkiloService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
