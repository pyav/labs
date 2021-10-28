const express = require('express')
const router = express.Router()
const Alien = require('../models/alien')

router.get('/', async(req, res) => {

    try {
        const aliens = await Alien.find()
        res.send(aliens)
    } catch (err) {
        res.send('Error: ' + err)
    }

})

router.get('/:id', async(req, res) => {

    try {
        const alien = await Alien.findById(req.params.id)
        res.send(alien)
    } catch (err) {
        res.send('Error: ' + err)
    }

})

router.post('/', async(req, res) => {
    const alien = new Alien({
        name: req.body.name,
        tech: req.body.tech,
        sub: req.body.sub
    })

    try {
        const data = await alien.save()
        res.json(data)
    } catch(err) {
        res.send('Error: ' + err)
    }
})

router.patch('/:id', async(req, res) => {
    const id = req.params.id
    try {
        const alien = await Alien.findById(id)
        alien.sub = req.body.sub
        const data = await alien.save()
        res.json(data)
    } catch (err) {
        res.send('Error: ' + res)
    }
})

router.delete('/:id', async(req, res) => {
    const id = req.params.id
    try {
        const alien = await Alien.findById(id)
        const data = await alien.remove()
        res.json(data)
    } catch(err) {
        res.send('Error: ' + err)
    }
})

module.exports = router

