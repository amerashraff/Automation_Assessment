export class HomePage {
  country_Btn = ".country-current";
  plan_Title = ".plan-title";
  language_Btn = "#translation-btn";
  plan_Price = ".price";
  country_Popup_Close = "#country-poppup-close";
  selected_Country = ".selected";
  countries_Dialog = ".country-select";

  getFixture(path: any) {
    return cy.fixture(path);
  }

  changeLangToEnglish() {
    cy.get(this.language_Btn)
      .invoke("text")
      .then((text) => {
        if (text.toLowerCase() !== "english") {
          cy.get(this.language_Btn).click();
        }
      });
  }
  changeCountry(countryName: string) {
    cy.get(this.country_Btn).first().click();
    cy.get(this.selected_Country)
      .invoke("text")
      .then((text) => {
        text.replace("\\s", "");
        text.replace("\\n", "");
        text.replace("\\r", "");
        if (text == countryName) {
          cy.get(this.country_Popup_Close).click();
        } else {
          cy.get(this.countries_Dialog).contains(countryName).click();
        }
      });
  }
  checkPlansName(plansTitles: string[]): any {
    cy.get(this.plan_Title).each(($el, index, $list) => {
      cy.wrap($el)
        .invoke("text")
        .then((text) => {
          expect(text.toUpperCase()).to.equal(plansTitles[index]);
        });
    });
  }
  checkPlansPriceAndCurrency(plansPrices: string[] , currencyName: string){
        cy.get(this.plan_Price).each(($el, index, $list) => {
            cy.wrap($el)
              .invoke("text")
              .then((text) => {
                expect(text).to.contains(plansPrices[index]);
                expect(text).to.contains(currencyName);
              });
          });
  }
}
