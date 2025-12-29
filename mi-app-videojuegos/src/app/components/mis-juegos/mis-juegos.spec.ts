import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MisJuegos } from './mis-juegos';

describe('MisJuegos', () => {
  let component: MisJuegos;
  let fixture: ComponentFixture<MisJuegos>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [MisJuegos]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MisJuegos);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
