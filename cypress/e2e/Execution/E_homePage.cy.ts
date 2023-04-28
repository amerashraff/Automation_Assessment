import { HomePage } from "../Pages/HomePage";

const homeObj = new HomePage();

before(() => {
  cy.visit("/");
});

beforeEach(() => {
  homeObj.getFixture("PlansWithPrices").as("data");
});

describe("Check plan's title and price and currency For EGYPT", () => {
  it("Check the language to be english", () => {
    homeObj.changeLangToEnglish();
  });
  it("Select the Egypt country", () => {
    homeObj.changeCountry("Egypt");
  });
  it("The plans title should be same as data in fixture file", () => {
    cy.get("@data").then((data) => {
      homeObj.checkPlansName(data.Egypt.PlansTitle);
    });
  });
  it("The plans prices should be same as data in fixture file", () => {
    cy.get("@data").then((data) => {
      homeObj.checkPlansPriceAndCurrency(data.Egypt.PlansPrice , data.Egypt.Currency);
    });
  });
});
describe("Check plan's title and price and currency For JORDAN", () => {
    it("Select the Jordan country", () => {
      homeObj.changeCountry("Jordan");
    });
    it("The plans title should be same as data in fixture file", () => {
      cy.get("@data").then((data) => {
        homeObj.checkPlansName(data.Jordan.PlansTitle);
      });
    });
    it("The plans prices should be same as data in fixture file", () => {
      cy.get("@data").then((data) => {
        homeObj.checkPlansPriceAndCurrency(data.Jordan.PlansPrice , data.Jordan.Currency);
      });
    });
  });
  describe("Check plan's title and price and currency For UAE", () => {
    it("Select the UAE country", () => {
      homeObj.changeCountry("UAE");
    });
    it("The plans title should be same as data in fixture file", () => {
      cy.get("@data").then((data) => {
        homeObj.checkPlansName(data.UAE.PlansTitle);
      });
    });
    it("The plans prices should be same as data in fixture file", () => {
      cy.get("@data").then((data) => {
        homeObj.checkPlansPriceAndCurrency(data.UAE.PlansPrice , data.UAE.Currency);
      });
    });
  });
