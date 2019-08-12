import {ConfirmationComponent} from './confirmation.component';

describe('ConfirmationComponent', () => {
  let component: ConfirmationComponent;
  let fakeDialogRef: any;

  beforeEach(() => {
    fakeDialogRef = {
      close(dialogResult?: boolean): void {
      }
    };
    component = new ConfirmationComponent(fakeDialogRef, {titleKey: 'foo', bodyKey: 'bar'});
  });

  it('should initialize bundle keys', () => {
    expect(component.titleKey).toBe('foo');
    expect(component.bodyKey).toBe('bar');
  });

  it('should close dialog with true value on confirm clicked', () => {
    spyOn(fakeDialogRef, 'close');
    component.onConfirm();
    expect(fakeDialogRef.close).toHaveBeenCalledWith(true);
  });
});
