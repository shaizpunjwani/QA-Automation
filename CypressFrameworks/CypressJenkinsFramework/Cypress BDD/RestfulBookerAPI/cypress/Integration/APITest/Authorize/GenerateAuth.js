// authUtils.js
const { Authorize } = require("../../../support/APIUtilis/APIUtils");

let authToken;

export const getAuthToken = () => {
  return authToken;
};

export const setAuthToken = (token) => {
  authToken = token;
};

export const authenticateAndGetToken = () => {
  return Authorize("admin", "password123").then((result) => {
    setAuthToken(result.token);
    return result.token;
  });
};
