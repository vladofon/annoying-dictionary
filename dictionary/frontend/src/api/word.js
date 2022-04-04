import { api } from '@/api/api-resource'

export default {
	create: word => api.post('words/create', word),
	edit: word => api.post('words/edit', word),
	list: () => api.get('words'),
	get: id => api.get(`words/${id}`),
	remove: id => api.delete(`words/${id}`)
}