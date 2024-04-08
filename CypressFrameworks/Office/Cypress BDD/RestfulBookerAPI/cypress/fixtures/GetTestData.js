import { Faker, en, faker } from '@faker-js/faker';


const payload={
    "firstname" : faker.person.firstName(),
    "lastname" : faker.person.lastName(),
    "totalprice" : faker.number.int({ min: 100, max: 90000}),
    "depositpaid" : true,
    "bookingdates" : {
        "checkin" : faker.date.anytime(),
        "checkout" : faker.date.anytime()
    },
    "additionalneeds" : faker.music.genre()
}

function Get_Create_Booking_Payload()
{
    return payload;
}

function removeKeyFromPayload(keyToRemove) {
    const modifiedPayload = { ...payload };
    recursiveKeyRemoval(modifiedPayload, keyToRemove);
    return modifiedPayload;
}

function recursiveKeyRemoval(obj, keyToRemove) {
    for (const prop in obj) {
        if (prop === keyToRemove) {
            delete obj[prop];
        } else if (typeof obj[prop] === 'object') {
            recursiveKeyRemoval(obj[prop], keyToRemove);
        }
    }
}

module.exports ={
    Get_Create_Booking_Payload,
    removeKeyFromPayload
}