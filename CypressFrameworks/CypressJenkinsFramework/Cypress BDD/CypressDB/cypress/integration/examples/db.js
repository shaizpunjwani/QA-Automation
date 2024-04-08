const sql = require('mssql');

const config = {
server: 'DESKTOP-BFVPL0E',
database: 'Northwind',
options: {
trustedConnection: true, // Use Windows authentication
},
};

async function connectToSSMS() {
try {
await sql.connect(config);
console.log('Connected to SSMS');
// Perform SQL operations here
} catch (err) {
console.error('Error connecting to SSMS', err);
} finally {
sql.close();
}
}

connectToSSMS();