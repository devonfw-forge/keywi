import {AbstractEto} from './AbstractEto';

export interface KeyObjectEto extends AbstractEto {
  key: string;
  name: string;
  comment: string;
  disabled: boolean;
}
