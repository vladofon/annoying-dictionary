import axios from 'axios' 

axios.defaults.withCredentials = true

export const api = new axios.create({
	baseURL: process.env.VUE_APP_BACKEND_URL,
	withCredentials: true
})