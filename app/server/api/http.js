import * as service from './service/event';

export function getEvents(req, res) {
  service.getEvents()
  .then((events) => res.json(events))
  .catch(err => {
    res.status(400);
    res.json({error: err});
  });
}