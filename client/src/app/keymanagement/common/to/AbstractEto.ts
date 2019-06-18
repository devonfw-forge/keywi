/**
 * Base class for all transfer objects.
 */
export interface AbstractEto {
  id?: number;
  modificationCounter?: number;
  revision?: number;
  modificationDate?: number;
}
