import { TestBed } from '@angular/core/testing';

import { KeylistDetailsResolverService } from './keylist-details-resolver.service';

xdescribe('KeylistDetailsResolverService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: KeylistDetailsResolverService = TestBed.get(KeylistDetailsResolverService);
    expect(service).toBeTruthy();
  });
});
