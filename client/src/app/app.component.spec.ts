import { TestBed, async } from '@angular/core/testing';
import { AppComponent } from './app.component';
describe('AppComponent', () => {
  beforeEach(async(() => {
    TestBed.configureTestingModule({
      providers: [
        AppComponent
      ],
    });
  }));
  it('should create the app', async(() => {
    const app = TestBed.get(AppComponent);
    expect(app).toBeTruthy();
  }));
});
