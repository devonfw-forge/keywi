/**
 * Base class for all transfer objects.
 */
export class AbstractEto {
  id: number;
  modificationCounter: number;
  revision: number;
  modificationDate: number;
}
