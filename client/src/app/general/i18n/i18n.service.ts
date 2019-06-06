import {Injectable} from '@angular/core';
import {TranslateService} from '@ngx-translate/core';
import translation_en from './translation_en';
import translation_de from './translation_de';
import {map} from 'rxjs/operators';

export class Language {

  static readonly ENGLISH: Language = {
    country: 'GB',
    language: 'en'
  };

  static readonly GERMAN: Language = {
    country: 'DE',
    language: 'de'
  };

  readonly country: string;
  readonly language: string;
}

export const defaultLanguage = Language.ENGLISH;

@Injectable({
  providedIn: 'root'
})
export class I18nService {

  readonly languages: Language[] = [Language.ENGLISH, Language.GERMAN];

  constructor(private translate: TranslateService) {

  }

  public configure() {
    this.translate.setTranslation(Language.ENGLISH.language, translation_en);
    this.translate.setTranslation(Language.GERMAN.language, translation_de);
    this.translate.setDefaultLang(defaultLanguage.language);
    return this.translate.use(this.translate.getBrowserLang())
      .pipe(map(_ => this.translate.currentLang));
  }
}
