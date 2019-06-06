import {KeyItemProperty} from './KeyItemProperty';
import {KeyObjectEto} from './KeyObjectEto';

export class KeyListEto extends KeyObjectEto {
  ordering: KeyItemProperty;
  valueRequired: boolean;
  permission: string;
  cacheable: boolean;
}
