import {KeyItemProperty} from './KeyItemProperty';
import {KeyObjectEto} from './KeyObjectEto';

export interface KeyListEto extends KeyObjectEto {
  ordering: KeyItemProperty;
  valueRequired: boolean;
  permission: string;
  cacheable: boolean;
}
