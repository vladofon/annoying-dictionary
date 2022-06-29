import { api } from '@/api/api-resource'

export default {
	create: word => api.post('words', word),
	edit: word => api.put(`words/${word.id}`, word),
	list: () => api.get('words'),
	get: id => api.get(`words/${id}`),
	delete: id => api.delete(`words/${id}`)
}