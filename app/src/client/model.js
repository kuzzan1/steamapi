const Falcor = require('falcor');
const FalcorDataSource = require('falcor-http-datasource');

const model = new Falcor.Model({
    source: new FalcorDataSource('/model.json')
});

module.exports = model
