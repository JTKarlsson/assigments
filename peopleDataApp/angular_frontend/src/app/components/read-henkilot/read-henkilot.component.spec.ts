import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ReadHenkilotComponent } from './read-henkilot.component';

describe('ReadHenkilotComponent', () => {
  let component: ReadHenkilotComponent;
  let fixture: ComponentFixture<ReadHenkilotComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ReadHenkilotComponent]
    });
    fixture = TestBed.createComponent(ReadHenkilotComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
