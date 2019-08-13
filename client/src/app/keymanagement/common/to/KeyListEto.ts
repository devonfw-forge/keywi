import {KeyObjectEto} from './KeyObjectEto';

export type KeyListOrdering = 'NAME' | 'KEY' | 'COMMENT' | 'VALUE';

export const allKeyListOrderings: () => Array<KeyListOrdering> = () => ['NAME', 'KEY', 'COMMENT', 'VALUE'];

export interface KeyListEto extends KeyObjectEto {
  ordering: KeyListOrdering;
  valueRequired: boolean;
  permission: string;
  cacheable: boolean;
}
